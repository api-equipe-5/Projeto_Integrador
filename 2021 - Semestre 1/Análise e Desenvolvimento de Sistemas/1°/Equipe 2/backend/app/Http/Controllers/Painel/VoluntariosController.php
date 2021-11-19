<?php

namespace App\Http\Controllers\Painel;

use App\Http\Controllers\Controller;
use App\Models\Voluntario;
use App\Models\Cadastro;
use App\Models\User;

use Illuminate\Http\Request;

class VoluntariosController extends Controller
{
    public function lista(){
        $voluntarios = Voluntario::where('tipo','!=','removido')->paginate();
        return view('admin.voluntarios.lista',compact('voluntarios'));
    }

    public function novo(){
        $dias_semana = [];

        return view('admin.voluntarios.novo',compact('dias_semana'));
    }

    public function store(Request $request){
        $data = $request->all();
        if(isset($data['dias_disponiveis'])){
            $dias_semana = implode(",",$data['dias_disponiveis']);
            $data['dias_disponiveis'] = $dias_semana;
        }
        
        Voluntario::create($data);
        return response()->json(['status'=>'ok']);
    }

    public function editar(Request $request, $id){
        $voluntario = Voluntario::where('id',$id)->first();
        $dias_semana = explode(",",$voluntario['dias_disponiveis']);
        return view('admin.voluntarios.editar',compact('voluntario','dias_semana'));
    }

    public function update(Request $request, $id){
        $data = $request->except('_token');
        $dias_semana = implode(",",$data['dias_disponiveis']);
        $data['dias_disponiveis'] = $dias_semana;
        $v = Voluntario::where('id',$id)->update($data);
        return response()->json(['status'=>'ok']);
    }

    public function delete(Request $request, $id){
        Voluntario::find($id)->update(['tipo'=>'removido']);
        return redirect()->route('admin.voluntarios.lista');
    }

    public function listaNovos(){
        $voluntarios = Cadastro::paginate();
        return view('admin.futuros.lista',compact('voluntarios'));
    }

    public function deleteView(Request $request, $id){
        Cadastro::where('id',$id)->delete();
        return redirect()->route('admin.futuros.lista');
    }
}
