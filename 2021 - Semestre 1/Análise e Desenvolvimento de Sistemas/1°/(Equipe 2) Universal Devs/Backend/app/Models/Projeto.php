<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Projeto extends Model
{
    protected $table = 'projeto';
  
    protected $fillable = [
        'id',
        'nome',
        'descricao',
        'voluntarios_id',
        'status',
        'slug',
        ];
}
