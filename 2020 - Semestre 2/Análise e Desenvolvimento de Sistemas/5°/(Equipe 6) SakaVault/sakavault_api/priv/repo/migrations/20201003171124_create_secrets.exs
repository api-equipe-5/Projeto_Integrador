defmodule SakaVault.Repo.Migrations.CreateSecrets do
  use Ecto.Migration

  def change do
    create table(:secrets) do
      add :name, :binary, null: false
      add :username, :binary, null: false
      add :password, :binary, null: false

      add :notes, :binary

      add :user_id, references(:users, type: :uuid, on_delete: :delete_all), null: false

      timestamps()
    end
  end
end
