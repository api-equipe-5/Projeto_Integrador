<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Participante extends Model
{
    protected $table = 'participante';
  
    protected $fillable = [
        'id',
        'matricula',
        'nome',
        'data_nascimento',
        'cep',
        'endereco',
        'cidade',
        'estado',
        'telefone',
        'email',
        'rg',
        'cpf',
        'status',
        ];
}
