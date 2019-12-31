# %%

from Evaluator import Evaluator
from flask import Flask
from flask import request
from flask import jsonify

app = Flask(__name__)

@app.route('/evaluate', methods=['post'])
def evaluate():
	data = request.get_json()
	# pred_ans = evaluator.evaluate(data)
	pred_ans = ['1', '2', '3', '4', '5', '6']
	return jsonify(pred_ans)


if __name__ == "__main__":
	# evaluator = Evaluator()
	# evaluator.load_encoder('output/encoder.pkl')
	# evaluator.load_model('output/model.h5')
	# evaluator.update()
	app.run(host='0.0.0.0', port=80)
