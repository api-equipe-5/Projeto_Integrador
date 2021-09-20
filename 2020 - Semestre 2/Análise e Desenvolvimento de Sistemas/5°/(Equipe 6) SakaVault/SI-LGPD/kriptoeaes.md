## Krypto & AES

#### Encrypt

```elixir
defmodule SakaVault.AES do
  @mode :aes_gcm
  @aad "AES256GCM" # Use AES 256 Bit Keys for Encryption.

  def encrypt(plain_text, key) do
    secret_key = :base64.decode(key)
    initial_vector = :crypto.strong_rand_bytes(16)

    {cipher, tag} =
      :crypto.block_encrypt(
        @mode,
        secret_key,
        initial_vector,
        {@aad, to_string(plain_text), 16}
      )

    initial_vector <> tag <> cipher
  end
end
```

Primeiro criamos um [**vetor aleatório de inicialização**](https://en.wikipedia.org/wiki/Initialization_vector) "**forte**" (IV) de **16 bytes** (**128 bits**) usando a função `strong_rand_bytes ` da biblioteca crypto do Erlang: http://erlang.org/doc/man/crypto.html#strong_rand_bytes-1. O "IV" garante que cada vez que um string/block de um texto/dado é criptografado, a `cifra` será diferente.

> Ter **diferentes** cifras para cada vez que um mesmo texto é criptografado é essencial para ["semântica da segurança"](https://en.wikipedia.org/wiki/Semantic_security) onde o uso da mesma chave de criptografia e algoritmos não permitem que um "atacante" interfira nos segmentos da mensagem criptografada.

Depois usamos a função [`block_encrypt/4`](http://erlang.org/doc/man/crypto.html#block_encrypt-4) do Erlang para criptografar o `plain_text` usando `:aes_gcm` ("*Advanced Encryption Standard Galois Counter Mode*") e uma chave de criptografia externa.

O `@aad` é um "atributo de modulo" (o equivalente a uma "constante" em Elixir) e é definido como `"AES256GCM"` e isso configura o modo de criptografia que estamos usando:

```
AES = Advanced Encryption Standard
256 = 256 Bit Key
GCM = Galois Counter Mode
```

E por último, retornamos o `IV`, a `tag` e a `cifra`, que é o que salvamos no banco de dados. Incluir o IV e a tag é essencial para permitir que seja possível descriptograr os dados, sem essas duas peças de informação, não é possível "reverter" o processo.

#### Decrypt

```elixir
defmodule SakaVault.AES do
  @mode :aes_gcm
  @aad "AES256GCM" # Use AES 256 Bit Keys for Encryption.

  def decrypt(<<initial_vector::binary-16, tag::binary-16, cipher_text::binary>>, key) do
    secret_key = :base64.decode(key)

    :crypto.block_decrypt(
      @mode,
      secret_key,
      initial_vector,
      {@aad, cipher_text, tag}
    )
  end
end
```

A função `decrypt` reverte todo o trabalho feito pela `encrypt`; ela aceita um binário, que contêm o IV, a tag, a cifra e retorna o `plain_text` original.

O primeiro passo é separar o `IV`, a `tag` e a `cifra` do argumento da função `decrypt` usando Pattern Matching de binários do Elixir.

> Se você não está familiarizado com a sintaxe de Pattern Matching de binários do Elixir: <<iv::binary-16, tag::binary-16, ciphertext::binary>>, leia o guia: https://elixir-lang.org/getting-started/binaries-strings-and-char-lists.html

A `cifra` é descriptografada usando a função [`block_decrypt/4`](http://erlang.org/doc/man/crypto.html#block_decrypt-4) do Erlang e temos de volta o `plain_text` original.
