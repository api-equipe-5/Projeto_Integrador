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
        'criador',
        'voluntarios_id',
        'status',
        'slug',
        'media_id',
        ];

        public function media(){
            return $this->hasOne(Media::class,'id','media_id');
        }
}
