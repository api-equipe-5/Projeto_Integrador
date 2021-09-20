<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Conteudos extends Model
{
    protected $table = 'conteudo';
  
    protected $fillable = [
        'id',
        'nome',
        'descricao',
        'slug',
        'status',
        ];
      
}
