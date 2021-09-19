.PHONY: start

start: 
	docker build -t spc .
	docker run -p 8888:8888 -v $(shell pwd):/notebooks -u "$$(id -u):$$(id -g)" spc
