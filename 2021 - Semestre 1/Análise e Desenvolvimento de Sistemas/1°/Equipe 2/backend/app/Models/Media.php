<?php
namespace App\Models;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Notifications\Notifiable;
use URL;
class Media extends Model
{
    
     protected $table = 'media';
  
    protected $fillable = [
        'id',
        'file',
        'alt',
        'path',
        'type',
        ];
        
        public function fullpatch(){
            return URL::to('/')."/uploads/img/".$this->file;
        }
}
