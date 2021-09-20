defmodule SakaVault.AESTest do
  use SakaVault.DataCase

  alias SakaVault.{AES, Krypto}

  setup do
    %{key: Krypto.secret_key("sakavault")}
  end

  describe ".encrypt/1" do
    test "encrypt includes the random initial vector in the value", %{key: key} do
      <<initial_vector::binary-16, cipher_text::binary>> = AES.encrypt("hello", key)

      assert is_binary(cipher_text)

      assert String.length(cipher_text) != 0
      assert String.length(initial_vector) != 0
    end

    test "encrypt doesn't produce the same cipher text twice", %{key: key} do
      assert AES.encrypt("hello", key) != AES.encrypt("hello", key)
    end

    test "reencrypt encrypted text", %{key: key} do
      encrypted_text = AES.encrypt("hello", key)
      reencrypted_text = AES.encrypt(encrypted_text, key)

      refute reencrypted_text == "hello"
      refute reencrypted_text == encrypted_text
    end
  end

  describe "decrypt/1" do
    test "decrypt cipher text", %{key: key} do
      plain_text =
        "hello"
        |> AES.encrypt(key)
        |> AES.decrypt(key)

      assert plain_text == "hello"
    end

    test "do not try to decrypt plain text", %{key: key} do
      assert AES.decrypt("hello", key) == "hello"
    end

    test "can't decrypt value with another key", %{key: key} do
      another_key = Krypto.secret_key("another key")

      plain_text =
        "hello"
        |> AES.encrypt(key)
        |> AES.decrypt(another_key)

      refute plain_text == "hello"
    end
  end
end
