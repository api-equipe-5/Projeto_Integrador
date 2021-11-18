from django.forms.models import BaseInlineFormSet
from django.forms import ModelForm
from .models import Produto, Variacao


class VariacaoObrigatoria(BaseInlineFormSet):
    def _construct_form(self, i, **kwargs):
        form = super(VariacaoObrigatoria, self)._construct_form(i, **kwargs)
        form.empty_permitted = False
        return form


class Postform(ModelForm):
    class Meta:
        model = Produto
        fields = ['nome', 'descricao_curta', 'descricao_longa', 'imagem', 'preco_marketing', 'preco_marketing_promocional', 'tipo']