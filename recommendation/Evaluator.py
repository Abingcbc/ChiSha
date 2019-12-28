import numpy as np
from urllib.request import urlopen
import pandas as pd
from deepctr.models import DIN,DeepFM
from deepctr.inputs import SparseFeat,VarLenSparseFeat,DenseFeat,get_feature_names
from sklearn.preprocessing import LabelEncoder, MinMaxScaler
from tensorflow.python.keras.preprocessing.sequence import pad_sequences
from ModelEncoder import ModelEncoder
import pickle

class Evaluator:
	def __init__(self):
		self.encoder = None
		self.model = None
		self.recipeDomain = None
	
	def load_encoder(self, path :str):
		self.encoder = pickle.load(path)
	
	def load_model(self, path: str):
		self.model = DIN()
		self.model.load_weights(path)
	
	def update(self):
		url = ''
		data_source = urlopen(url)
		self.recipeDomain = pd.read_csv(data_source)
		
	def evaluate(self, user_domain :dict):
		#Cartesian product
	