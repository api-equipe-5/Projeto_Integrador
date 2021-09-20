<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateParticipanteTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('participante', function (Blueprint $table) {
            $table->id();
            $table->string('matricula')->nullable();
            $table->string('nome')->nullable();
            $table->string('data_nascimento')->nullable();
            $table->string('cep')->nullable();
            $table->string('endereco', 500)->nullable();
            $table->string('cidade')->nullable();
            $table->string('estado')->nullable();
            $table->string('telefone')->nullable();
            $table->string('email')->nullable();
            $table->string('rg')->nullable();
            $table->string('cpf')->nullable();
            $table->enum('status',['ativo','inativo','removido']);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('participante');
    }
}
