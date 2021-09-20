## Modelos de dados

#### User

```elixir
schema :users do
  field :name, :binary
  field :email, :binary

  field :email_hash, :binary
  field :password_hash, :binary
end
```

Os campos `nome` e `email` são criptografados no banco de dados usando o módulo <a href=" ">Krypto e AES</a>. Já os campos `email_hash` e `password_hash` são guardados em formato de hash.

- `password_hash` é o hash da senha do usuário usando Argon2
- `email_hash` é o hash do e-mail do usuário, assim conseguimos fazer um "lookup" para que este consiga fazer login sem comprometer a segurança dos dados

A razão por estarmos criando os campos criptografados/hash como `binary` é porque este é o tipo de dado Ecto/SQL *mais eficiente* para guardar dados criptografados; salvá-los como `string` requer mais espaço em disco (em bytes) para a *mesma informação* e isso é um desperdício de espaço sem qualquer benefício para a segurança ou desempenho. 

Veja mais em:
* https://dba.stackexchange.com/questions/56934/what-is-the-best-way-to-store-a-lot-of-user-encrypted-data
* https://elixir-lang.org/getting-started/binaries-strings-and-char-lists.html

#### Secret

```elixir
schema "secrets" do
  field :user_id, :uuid
  
  field :name, :binary
  field :notes, :binary
  field :username, :binary
  field :password, :binary
end

```
