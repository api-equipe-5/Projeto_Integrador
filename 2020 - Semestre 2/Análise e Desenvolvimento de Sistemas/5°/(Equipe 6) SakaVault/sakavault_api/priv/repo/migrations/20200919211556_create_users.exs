defmodule SakaVault.Repo.Migrations.CreateUsers do
  use Ecto.Migration

  def change do
    create table(:users) do
      add :name, :binary, null: false
      add :email, :binary, null: false
      add :email_hash, :binary, null: false
      add :password_hash, :binary, null: false

      timestamps()
    end

    create unique_index(:users, [:email_hash])
  end
end
