#!/usr/bin/env python
# coding: utf-8

# **------------ This is just a test on how to perform standard scaling and predict value on new input from user   ------------**

# # 1. Import dataset and necessary libraries:

# In[1]:


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns


# In[2]:


df = pd.read_csv("heart.csv")


# In[3]:


df.head()


# **I. Original shape of dataset:**

# In[4]:


df.shape


# **II. Random rows selection from the dataset, around 20% hence 205 rows:**}

# In[5]:


test = df.sample(205, replace=False)


# In[6]:


test.shape


# **III. Removing the randomly selected rows from the dataset:**

# In[7]:


df = df.drop(test.index)


# In[8]:


df.shape


# **IV. Train datatset:**

# In[9]:


train = df


# In[10]:


train.shape


# In[11]:


train.head()


# **V. Test dataset:**

# In[12]:


test.shape


# In[13]:


test.head()


# # 2. Split the dataset into input and output columns:

# In[14]:


x = df.iloc[: , 0:13]


# In[15]:


y = df.iloc[:, 13]


# **I. Perform Standard Scaling on input data: [IMPORTANT]**

# In[16]:


from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler().fit(x)
x = scaler.transform(x)


# **Here, I have trained the scaler using our training data to obtain the mean and standard deviation,so that i can later use the scaler to perform standard scaling on user input.
# The scaler itself isn't used for model training. Its purpose is to calculate and store scaling parameters for later use.**

# In[17]:


scaler


# In[18]:


knn = KNeighborsClassifier(n_neighbors=3)
knn.fit(x, y)


# # 3. Test dataset:

# In[19]:


test_x = test.iloc[:, 0:13]
test_y = test.iloc[:, 13]


# In[20]:


test_x.head()


# In[21]:


test_x.iloc[[1]]


# In[22]:


print(test_y.iloc[1])


# **I. Perfom standard scaling on single row with the help of scaler:**

# In[23]:


scaled_input = scaler.transform(test_x.iloc[[1]])


# In[24]:


scaled_input


# In[25]:


test_y.iloc[1]


# **II. Model prediction:**

# In[26]:


y = knn.predict(scaled_input)


# In[27]:


y


# **Model correctly predicted the output**
