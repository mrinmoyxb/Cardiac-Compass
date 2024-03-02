#!/usr/bin/env python
# coding: utf-8

# # 1. Import the dataset and necessary libraries:

# In[1]:


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns


# In[2]:


df = pd.read_csv("E:\Android\heart.csv")


# In[3]:


df.head()


# # 2. Dataset Exploration: 

# I. Number of rows and columns in the dataset:

# In[4]:


rows, columns = df.shape
print(f"Number of rows: {rows}")
print(f"Number of columns: {columns}")


# II. Columns in the dataset are:

# In[5]:


print(f"Columns in the datatset are: \n{df.columns}")


# III. Statistical analysis of the dataset:

# In[6]:


print(f"Statistical analysis of the dataset: \n{df.describe()}")


# IV. Number of patients with heart disease and without heart disesase:

# In[7]:


normal, defect = df.groupby('target')['age'].count()
print(f"Total patients with no heart disease: {normal}")
print(f"Total patients with heart disease: {defect}")


# V. Visualization of the datatset:

# In[8]:


sns.countplot(x = 'target', palette = 'mako', data = df)


# # 3. Data Cleaning and Processing:

# I. Find missing values:

# In[9]:


df.isna().sum()


# II. Find duplicate values:

# In[10]:


index = df.duplicated(keep=False).count()
if index == rows:
    print("There are no duplicates in the dataset")


# # 4. Split the datatset into input and output/target columns:

# In[11]:


x = df.iloc[:, 0:13].values
y = df.iloc[:, 13]


# # 5. Preprocessing our train set:

# In[12]:


from sklearn.preprocessing import StandardScaler


# In[13]:


sc = StandardScaler()
x = sc.fit_transform(x)


# # 6. Split the datatset into train and test set:

# In[14]:


from sklearn.model_selection import train_test_split


# In[15]:


x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 0.2, random_state=30)


# # 7. Value of K for KNearestNeighbor:

# In[16]:


from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score, confusion_matrix


# I. Square root method:

# In[17]:


k = round(np.sqrt(len(x)))
print(f"Value of k: {k}")


# II. Trial and hit method:

# In[18]:


l = []
for i in range(3, 34):
    knn = KNeighborsClassifier(n_neighbors=i)
    knn.fit(x_train, y_train)
    y_pred = knn.predict(x_test)
    a = accuracy_score(y_test, y_pred)
    l.append(a)


# In[19]:


for k, score in enumerate(l, 3):
    print(f"k value: {k},  Accuracy score: {score}")


# III. Visualization of k value and accuracy score:

# In[20]:


plt.plot(range(3,34), l)
plt.xticks(range(3,30))
plt.grid()
plt.show()


# # 8. Train the model using KNearest Neighbour:

# In[21]:


knn = KNeighborsClassifier(n_neighbors=3)
knn.fit(x_train, y_train)


# In[22]:


y_pred1 = knn.predict(x_test)


# # 9. Model performance using Accuracy Score and Confusion Matrix:

# I. Accuracy Score:

# In[23]:


from sklearn.metrics import accuracy_score
print(f"Accuracy Score: {accuracy_score(y_test, y_pred1)}")


# II. Confusion Matrix: 

# In[24]:


sns.heatmap(confusion_matrix(y_test, y_pred), annot=True)

