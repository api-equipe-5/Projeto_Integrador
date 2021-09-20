<?php

namespace App\Http\Controllers\Painel;

use App\Http\Controllers\Controller;
use App\Models\Projeto;
use Illuminate\Http\Request;
use Illuminate\Support\Str;

class ProjetosController extends Controller
{
    public function lista(){
        $projetos = Projeto::where('status','!=','removido')->paginate();
        return view('admin.projetos.lista',compact('projetos'));
    }

    public function novo(){
        return view('admin.projetos.novo');
    }

    public function store(Request $request){
        $data = $request->except('_token');
        $data['slug'] = Str::slug($data['nome']);
        Projeto::create($data);
        return response()->json(['status'=>'ok']);
    }

    public function editar(Request $request, $id){
        $projeto = Projeto::where('id',$id)->first();
        return view('admin.projetos.editar',compact('projeto'));
    }

    public function update(Request $request, $id){
        $data = $request->except('_token');
        $v = Projeto::where('id',$id)->update($data);
        return response()->json(['status'=>'ok']);
    }

    public function delete(Request $request, $id){
        Projeto::find($id)->update(['status'=>'removido']);
        return redirect()->route('admin.projetos.lista');
    }
}
