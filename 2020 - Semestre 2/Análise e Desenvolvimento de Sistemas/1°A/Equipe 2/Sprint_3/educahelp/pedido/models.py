from django.db import models
from django.contrib.auth.models import User
# from matplotlib import pyplot as plt
# from pylab import *
# import PIL, PIL.Image, StringIO
# import io




class Pedido(models.Model):
    usuario = models.ForeignKey(User, on_delete=models.CASCADE)
    total = models.FloatField()
    qtd_total = models.PositiveIntegerField()
    status = models.CharField(
        default="C",
        max_length=1,
        choices=(
            ('A', 'Aprovado'),
            ('C', 'Criado'),
            ('R', 'Reprovado'),
            ('P', 'Pendente'),
            ('E', 'Enviado'),
            ('F', 'Finalizado'),
        )
    )

    def __str__(self):
        return f'Pedido N. {self.pk}'


class ItemPedido(models.Model):
    pedido = models.ForeignKey(Pedido, on_delete=models.CASCADE)
    produto = models.CharField(max_length=255)
    produto_id = models.PositiveIntegerField()
    variacao = models.CharField(max_length=255)
    variacao_id = models.PositiveIntegerField()
    preco = models.FloatField()
    preco_promocional = models.FloatField(default=0)
    quantidade = models.PositiveIntegerField()
    imagem = models.CharField(max_length=2000)

    def __str__(self):
        return f'Item do {self.pedido}'

    class Meta:
        verbose_name = 'Item do pedido'
        verbose_name_plural = 'Itens do pedido'


# def relatorio(request):
#      Construct the graph
#     x = arange(0, 2*pi, 0.01)
#     s = cos(x)**2
#     plot(x, s)

#     xlabel('xlabel(X)')
#     ylabel('ylabel(Y)')
#     title('Simple Graph!')
#     grid(True)

#     Store image in a string buffer
#     buffer = StringIO.StringIO()
#     canvas = pylab.get_current_fig_manager().canvas
#     canvas.draw()
#     pilImage = PIL.Image.fromstring("RGB", canvas.get_width_height(), canvas.tostring_rgb())
#     pilImage.save(buffer, "PNG")
#     pylab.close()

#     Send buffer in a http response the the browser with the mime type image/png set
#     return HttpResponse(buffer.getvalue(), mimetype="image/png")