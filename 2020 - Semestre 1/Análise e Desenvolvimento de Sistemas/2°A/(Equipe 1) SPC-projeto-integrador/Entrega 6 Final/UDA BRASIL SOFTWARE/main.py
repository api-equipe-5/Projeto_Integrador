import os
from flask import Flask, render_template, redirect, url_for, request, flash, session
from werkzeug.utils import secure_filename
from controller import get_ranking

app = Flask(__name__, template_folder='templates')
UPLOAD_FOLDER = os.path.join(os.getcwd(), 'Dados/Importados')


@app.route('/')
def main():
    # Chama a função screen1 (Para sempre redirecionar para a tela de login)
    return redirect(url_for('screen1'))


@app.route('/login')
def screen1():
    return render_template('screen1.html')


@app.route('/input')
def screen2():
    return render_template('screen2.html')


@app.route('/rank')
def rank():
    ranking = get_ranking()
    return render_template('ranking.html', ranking=ranking)


@app.route('/upload', methods=['GET', 'POST'])
def upload():
    # A variável "file" recebe o arquivo vindo da requisição
    file = request.files['inputFile']
    savePath = os.path.join(UPLOAD_FOLDER, secure_filename(file.filename))
    file.save(savePath)
    flash(f'Arquivo {file.filename} enviado com sucesso', 'info')
    return redirect(url_for('screen2'))


if __name__ == "__main__":
    app.secret_key = 'super secret key'
    

    app.run(debug=True)
