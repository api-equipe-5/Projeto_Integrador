defmodule SakaVault.AES do
  @moduledoc false

  # Use AES 256 Bit Keys for Encryption.
  @mode :aes_gcm
  @aad "AES256GCM"

  def encrypt(<<_::binary-16, _::binary-16, _::binary>> = cipher_text, key) do
    cipher_text
    |> decrypt(key)
    |> encrypt(key)
  end

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

  def decrypt(<<initial_vector::binary-16, tag::binary-16, cipher_text::binary>>, key) do
    secret_key = :base64.decode(key)

    :crypto.block_decrypt(
      @mode,
      secret_key,
      initial_vector,
      {@aad, cipher_text, tag}
    )
  end

  def decrypt(plain_text, _), do: plain_text
end
