FROM python:3.8
LABEL maintainer "Ariana Cursino"

WORKDIR /mapaquali

COPY requirements.txt ./

RUN pip install -r requirements.txt

#EXPOSE 16160   

COPY . /mapaquali

ENTRYPOINT ["python"]

CMD ["dash_index.py"] 
