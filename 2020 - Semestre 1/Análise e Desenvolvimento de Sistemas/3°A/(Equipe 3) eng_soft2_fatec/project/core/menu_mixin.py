from django.urls import reverse_lazy
from tools.views.mixins import MenuMixin
from rules.contrib.views import PermissionRequiredMixin


class ProjetoMenuMixin(MenuMixin, PermissionRequiredMixin):
    permission_required = 'true'

    def get_menu(self):
        return {
            'administracao': {
                'label': 'Administração',
                'perm': '',
                'icon': 'fa-cogs',
                'url': '#',
                'active': False,
                'subsections': [
                    ('usuarios', reverse_lazy('user_list'), 'Usuários', ''),
                ]
            },
            'vagas': {
                'label': 'Vagas',
                'perm': '',
                'icon': 'fa-cogs',
                'url': '#',
                'active': False,
                'subsections': [
                    ('vagas', reverse_lazy('vaga_list'), 'Vagas', ''),
                    ('candidatos', reverse_lazy('candidato_list'), 'Candidatos', ''),
                ]
            },
            'skills': {
                'label': 'Skills',
                'perm': '',
                'icon': 'fa-cogs',
                'url': '#',
                'active': False,
                'subsections': [
                    ('habilidades', reverse_lazy('habilidade_list'), 'Habilidades', ''),
                    ('competencias', reverse_lazy('competencia_list'), 'Competências', ''),
                ]
            }
        }
