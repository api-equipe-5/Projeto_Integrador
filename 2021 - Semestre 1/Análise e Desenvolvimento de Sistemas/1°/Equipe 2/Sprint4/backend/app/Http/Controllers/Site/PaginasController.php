<?php

namespace App\Http\Controllers\Site;

use App\Http\Controllers\Controller;
use App\Models\Voluntario;
use App\Models\Mensagens;
use App\Models\Projeto;
use App\Models\Cadastro;
use Illuminate\Http\Request;
use Illuminate\Support\Str;
use DB;

class PaginasController extends Controller
{
    public function Home(){
        $projetos = Projeto::where('status','ativo')->take(3)->get();
        $i = count($projetos);
        return view ('src.index',compact('projetos','i'));
    }

    public function voluntarios(){
        $voluntarios = Voluntario::where('status','ativo')->get();
        return view('src.voluntarios', compact('voluntarios'));
    }

    public function projetos(){
        $projetos = Projeto::where('public', 1)->get();
        return view('src.projetos', compact('projetos'));
    }

    public function Select(Request $request, $slug){
        // $conteudo = Conteudos::where('slug',$slug)->where('status','ativo')->first();
        $conteudo = DB::select('select * from conteudo where slug = ?', [$slug]);
        if(!$conteudo){
            return view('errors.404');
        }
        else{
            return view("src.interno",compact('conteudo'));
        }
    }

    public function projeto(Request $request, $slug){
        $projeto = Projeto::where('slug',$slug)->where('status','!=','removido')->where('status','!=','removido')->first();
        if(!$projeto){
            return view('errors.404');
        }
        else{
            return view("src.interno",compact('projeto'));
        }
    }

    public function contato(Request $request){
        return view("src.contato");
    }

    public function enviar_contato(Request $request){
        $data = $request->all();
        Mensagens::create($data);
        return response()->json(['status'=>'ok']);
    }

    public function cadastro(Request $request){
        return view("src.cadastro");
    }

    public function enviar_cadastro(Request $request){
        $data = $request->all();
        Cadastro::create($data);
        return response()->json(['status'=>'ok']);
    }
}


       
