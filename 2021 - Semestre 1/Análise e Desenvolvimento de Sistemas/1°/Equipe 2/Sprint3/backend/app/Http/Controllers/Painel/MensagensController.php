<?php

namespace App\Http\Controllers\Painel;
use App\Http\Controllers\Controller;
use App\Models\Mensagens;
use Illuminate\Http\Request;
use DB;
class MensagensController extends Controller
{
    public function ver_mensagem(Request $request,$id){
        $msg = Mensagens::where('id',$id)->first();
        return view('admin.mensagens',compact('msg'));
    }

    public function delete_msg(Request $request, $id){
        $msg = Mensagens::where('id',$id)->delete();
        return redirect()->route('admin.home');

    }
}
