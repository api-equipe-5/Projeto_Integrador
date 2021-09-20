<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Voluntario extends Model
{
    protected $table = 'voluntarios';
  
    protected $fillable = [
        'id',
        'nome',
        'rg',
        'cpf',
        'endereco',
        'cidade',
        'estado',
        'nacionalidade',
        'profissao',
        'tipo',
        'telefone',
        'email',
        'horario',
        'dias_disponiveis',
        ];
}
