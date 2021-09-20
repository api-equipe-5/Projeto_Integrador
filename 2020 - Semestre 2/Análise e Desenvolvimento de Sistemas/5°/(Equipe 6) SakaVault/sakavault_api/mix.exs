defmodule SakaVault.MixProject do
  use Mix.Project

  def project do
    [
      app: :sakavault,
      version: "0.1.0",
      elixir: "~> 1.9",
      elixirc_paths: elixirc_paths(Mix.env()),
      test_coverage: [tool: ExCoveralls],
      compilers: [:phoenix] ++ Mix.compilers(),
      start_permanent: Mix.env() == :prod,
      aliases: aliases(),
      deps: deps(),
      preferred_cli_env: [
        ci: :test,
        fast_ci: :test,
        coveralls: :test,
        "coveralls.html": :test
      ]
    ]
  end

  # Configuration for the OTP application.
  #
  # Type `mix help compile.app` for more information.
  def application do
    [
      mod: {SakaVault.Application, []},
      extra_applications: [:logger, :runtime_tools, :crypto]
    ]
  end

  # Specifies which paths to compile per environment.
  defp elixirc_paths(:dev), do: ["lib", "test/support/factories.ex"]
  defp elixirc_paths(:test), do: ["lib", "test/support"]
  defp elixirc_paths(_), do: ["lib"]

  # Specifies your project dependencies.
  #
  # Type `mix help deps` for examples and options.
  defp deps do
    [
      # Environment
      {:confex, "~> 3.4.0"},

      # General
      {:jason, "~> 1.0"},

      # Auth
      {:guardian, "~> 2.1"},
      {:corsica, "~> 1.1"},

      # Aws
      {:ex_aws, "~> 2.1"},
      {:ex_aws_secretsmanager, "~> 2.0"},
      {:hackney, "~> 1.9"},

      # Securely hashing & verifying passwords
      {:argon2_elixir, "~> 1.3"},

      # Phoenix
      {:phoenix, "~> 1.5.0"},

      # Ecto
      {:phoenix_ecto, "~> 4.1"},
      {:ecto_sql, "~> 3.4.4"},
      {:postgrex, ">= 0.0.0"},
      {:plug_cowboy, "~> 2.0"},

      # Metrics
      {:telemetry_metrics, "~> 0.4"},
      {:telemetry_poller, "~> 0.4"},

      # Development and testing
      {:mox, "~> 1.0", only: :test},
      {:faker, "~> 0.15", only: [:dev, :test]},
      {:ex_machina, "~> 2.4", only: [:dev, :test]},
      {:credo, "~> 1.4", only: [:dev, :test], runtime: false},
      {:sobelow, "~> 0.10", only: [:dev, :test], runtime: false},
      {:excoveralls, "~> 0.13", only: [:dev, :test], runtime: false},

      # Production releases
      {:distillery, "~> 2.1", runtime: false}
    ]
  end

  # Aliases are shortcuts or tasks specific to the current project.
  # For example, to install project dependencies and perform other setup tasks, run:
  #
  #     $ mix setup
  #
  # See the documentation for `Mix` for more info on aliases.
  defp aliases do
    [
      setup: ["deps.get", "ecto.setup"],
      "ecto.setup": ["ecto.create", "ecto.migrate", "run priv/repo/seeds.exs"],
      "ecto.reset": ["ecto.drop", "ecto.setup"],
      test: ["ecto.create --quiet", "ecto.migrate --quiet", "test"],
      ci: [
        "format --check-formatted",
        "clean",
        "compile --warnings-as-errors --all-warnings",
        "fast_ci"
      ],
      fast_ci: [
        "ecto.create",
        "ecto.migrate",
        "credo --strict",
        "sobelow -i Config.HTTPS --skip --verbose --exit",
        "coveralls.html --raise --slowest 10"
      ]
    ]
  end
end
