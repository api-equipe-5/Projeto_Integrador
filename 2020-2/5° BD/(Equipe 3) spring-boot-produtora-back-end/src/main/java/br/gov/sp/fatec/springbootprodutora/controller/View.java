package br.gov.sp.fatec.springbootprodutora.controller;

public class View {

    public static class UsuarioResumo{}

    public static class UsuarioCompleto extends UsuarioResumo {}

    public static class Autorizacao{}

    public static class Filmagem{}

    public static class Filme extends Filmagem{}

    public static class Novela extends Filmagem{}

    public static class Pessoa {}

    public static class PessoaCompleta extends Pessoa {}

    public static class Diretor extends PessoaCompleta {}

    public static class Ator extends PessoaCompleta {}

    public static class Duble extends PessoaCompleta {}
 
}