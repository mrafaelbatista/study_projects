from flask import Flask, request, redirect, url_for, render_template
from flask_bootstrap import Bootstrap


app = Flask(__name__)
Bootstrap(app)


# Criando uma rota
@app.route("/")
def index():
    return "<a href='/posts'>Posts</a>"


# @app.route("/response")
# def response():
#     headers = {
#         "Content-Type": "text/html"
#     }
#     return Response("Resposta do servidor", 200, headers=headers)


@app.route("/response")
def response():
    return render_template("response.html")

@app.route("/redirect")
def redirect2():
    # return redirect("/response")
    return redirect(url_for("response"))


@app.route("/posts")
def posts():
    titulo = request.args.get("titulo")
    data = dict(
        path=request.path,
        referrer=request.referrer,
        content_type=request.content_type,
        method=request.method,
        titulo=titulo
    )
    return data


# O que vier abaixo não pode ser importardo
if __name__ == "__main__":
    # app.run()
    # Com o debug ativo a cada alteração ele já reinicia o servidor
    app.run(debug=True)
