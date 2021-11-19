<?php

namespace App\Http\Controllers\Painel;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\User;

class UserController extends Controller
{
    public function lista(){
        $usuarios = User::paginate();
        return view('admin.users.lista',compact('usuarios'));
    }
    public function novo(){
        return view('admin.users.new');
    }

    public function create(Request $request){
        $data = $request->all();
        if($data['tipo'] == 'adm'){
            User::create([
                'name'=>$data['nome'],
                'password'=>$data['password'],
                'tipo'=>'SuperAdmin',
                'email'=>$data['email'],
            ]);
        }else{
            User::create([
                'name'=>$data['nome'],
                'password'=>$data['password'],
                'tipo'=>'Admin',
                'email'=>$data['email'],
            ]);
        }
    }

    public function editar(Request $request, $id)
    {
        $data = $request->all();
        $usuario = User::where('id', $id)->first();
        return view ('admin.users.edit',compact('usuario'));
    }

    public function update(request $request,$id)
    {
        $data = $request->all();
        User::find($id)->update([
            'name' => $data['name'],
            'email' => $data['email'],
            'password' => bcrypt($data['password']),
        ]);
        return response()->json(['status'=>'ok']);

    }

    public function delete(Request $request, $id)
    {
        User::where('id', $id)->delete();
        return redirect()->route ('admin.users.lista');
    }
}
