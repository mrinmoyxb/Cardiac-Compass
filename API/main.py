import pickle
import numpy as np
import pandas as pd
from flask import Flask, request, jsonify
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split

model = pickle.load(open('HeartDiseaseDetectionModel.pkl', 'rb'))

app = Flask(__name__)

df = pd.read_csv("heart.csv")
x = df.iloc[:, 0:13].values
y = df.iloc[:, 13]
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 0.2, random_state=30)
scaler = StandardScaler().fit(x)

@app.route("/")
def homepage():
    return "Heart Disease Detection Model API"

@app.route('/predict', methods = ['POST'])
def predict():
    age: int = request.form.get('age')
    sex: int = request.form.get('sex')
    cp: int = request.form.get('cp')
    trestbps: int = request.form.get('trestbps')
    chol: int = request.form.get('chol')
    fbs: int = request.form.get('fbs')
    restecg: int = request.form.get('restecg')
    thalach: int = request.form.get('thalach')
    exang: int = request.form.get('exang')
    oldpeak: float = request.form.get('oldpeak')
    slope: int = request.form.get('slope')
    ca: int = request.form.get('ca')
    thal: int = request.form.get('thal')
    
    input_query = np.array([[age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal]])
    input = scaler.transform(input_query)
    result = model.predict(input)
    return jsonify({'target value': str(result[0])})

if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True)