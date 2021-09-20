defmodule SakaVault.Support.Factories do
  @moduledoc false

  @password_hash "$argon2id$v=19$m=65536,t=6,p=1$BoA94/xOfPZWnh+9yvejqQ$hrQwlCI6D51IVefWQ41uIoySMyYk0pY1cGcmEd/YQpU"

  use ExMachina.Ecto, repo: SakaVault.Repo

  alias Faker.Person.PtBr, as: Brazilian

  alias SakaVault.{
    Accounts.User,
    Krypto,
    Vault.Secret
  }

  def user_factory do
    name = Brazilian.name()

    email =
      name
      |> String.downcase()
      |> String.replace(~r/[^a-zA-Z]/, "")

    email = "#{email}@#{Faker.Internet.free_email_service()}"
    email_hash = Krypto.hash_value(email)

    %User{
      name: name,
      email: email,
      email_hash: email_hash,
      password: "password1234",
      password_hash: @password_hash
    }
  end

  def secret_factory do
    %Secret{
      name: "website",
      username: "username",
      password: "password",
      user: insert(:user)
    }
  end
end
