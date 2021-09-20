defmodule SakaVaultWeb.Plugs.CORS do
  @moduledoc false

  use Corsica.Router,
    origins: [
      ~r{^https?:\/\/0.0.0.0:\d+$},
      ~r{^https?:\/\/127.0.0.1:\d+$},
      ~r{^https?:\/\/localhost:\d+$},
      ~r{^https?:\/\/sakavault\.netlify\.app$}
    ],
    allow_headers: ~w(
      accept
      authorization
      content-type
      access-control-allow-methods
      access-control-allow-origin
    ),
    allow_credentials: true,
    max_age: 86_400

  resource("/*")
end
