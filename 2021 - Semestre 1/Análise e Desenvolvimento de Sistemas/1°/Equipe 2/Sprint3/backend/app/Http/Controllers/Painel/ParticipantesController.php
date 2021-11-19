<?php

namespace App\Http\Controllers\Painel;
use App\Models\Participante;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class ParticipantesController extends Controller
{
    public function lista(){
        $participantes = Participante::where('status','!=','removido')->paginate();
        return view('admin.participantes.lista',compact('participantes'));
    }

    public function novo(){
        return view('admin.participantes.novo');
    }

    public function store(Request $request){
        $data = $request->all();
        Participante::create($data);
        
        return response()->json(['status'=>'ok']);
    }

    public function editar(Request $request, $id){
        $participante = Participante::where('id',$id)->first();
        return view('admin.participantes.editar',compact('participante','dias_semana'));
    }

    public function update(Request $request, $id){
        $data = $request->except('_token');
        $v = Participante::where('id',$id)->update($data);
        return response()->json(['status'=>'ok']);
    }

    public function delete(Request $request, $id){
        Participante::find($id)->update(['tipo'=>'removido']);
        return redirect()->route('admin.participantes.lista');
    }
}
