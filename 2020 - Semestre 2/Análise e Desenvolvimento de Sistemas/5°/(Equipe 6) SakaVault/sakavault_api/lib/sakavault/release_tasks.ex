defmodule SakaVault.ReleaseTasks do
  @moduledoc false

  @otp_app :sakavault

  def create_database do
    for repo <- repos() do
      IO.puts("Creating database for #{repo}...")

      case repo.__adapter__.storage_up(repo.config) do
        :ok ->
          IO.puts("Database created.")

        {:error, :already_up} ->
          IO.puts("Database for #{repo} has already been created.")

        {:error, term} ->
          raise "The database for #{repo} couldn't be created: #{inspect(term)}"
      end
    end
  end

  def migrate_database do
    for repo <- repos() do
      IO.puts("Running migrations for #{repo}")

      {:ok, _, _} = Ecto.Migrator.with_repo(repo, &Ecto.Migrator.run(&1, :up, all: true))

      IO.puts("#{repo} migrated.")
    end
  end

  defp repos do
    Application.load(@otp_app)
    Application.get_env(@otp_app, :ecto_repos, [])
  end
end
