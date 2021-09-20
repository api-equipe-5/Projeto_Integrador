## Links úteis, FAQ & Leitura

+ Bits and Bytes: https://web.stanford.edu/class/cs101/bits-bytes.html
+ Thinking in Ecto - Schemas and Changesets:
http://cultofmetatron.io/2017/04/22/thinking-in-ecto---schemas-and-changesets/
+ Initialization Vector Length:
https://stackoverflow.com/questions/4608489/how-to-pick-an-appropriate-iv-initialization-vector-for-aes-ctr-nopadding (128 bits is 16 bytes).
+ What is the effect of the different AES key lengths?
https://crypto.stackexchange.com/questions/3615/what-is-the-effect-of-the-different-aes-key-lengths
+ How is decryption done in AES CTR mode?: https://crypto.stackexchange.com/questions/34918/how-is-decryption-done-in-aes-ctr-mode
+ Block Cipher Counter (CTR) Mode:
https://en.wikipedia.org/wiki/Block_cipher_mode_of_operation#Counter_.28CTR.29
+ Is AES-256 _weaker_ than 192 and 128 bit versions?
https://crypto.stackexchange.com/questions/5118/is-aes-256-weaker-than-192-and-128-bit-versions
+ What are the practical differences between 256-bit, 192-bit, and 128-bit AES encryption?
https://crypto.stackexchange.com/questions/20/what-are-the-practical-differences-between-256-bit-192-bit-and-128-bit-aes-enc
+ **How to Choose** an **Authenticated Encryption mode**
(_by Matthew Green cryptography professor at Johns Hopkins University_):
https://blog.cryptographyengineering.com/2012/05/19/how-to-choose-authenticated-encryption
+ How to choose an AES encryption mode (CBC ECB CTR OCB CFB)? (v. long answers, but good comparison!)
https://stackoverflow.com/questions/1220751/how-to-choose-an-aes-encryption-mode-cbc-ecb-ctr-ocb-cfb
+ AES GCM vs CTR+HMAC tradeoffs:
https://crypto.stackexchange.com/questions/14747/gcm-vs-ctrhmac-tradeoffs
+ Galois/Counter Mode for symmetric key cryptographic block ciphers:
https://en.wikipedia.org/wiki/Galois/Counter_Mode
+ What is the difference between CBC and GCM mode?
https://crypto.stackexchange.com/questions/2310/what-is-the-difference-between-cbc-and-gcm-mode
+ Ciphertext and tag size and IV transmission with AES in GCM mode:
https://crypto.stackexchange.com/questions/26783/ciphertext-and-tag-size-and-iv-transmission-with-aes-in-gcm-mode
+ How long (in letters) are encryption keys for AES?
https://security.stackexchange.com/questions/45318/how-long-in-letters-are-encryption-keys-for-aes
+ Why we can't implement AES 512 key size?
https://crypto.stackexchange.com/questions/20253/why-we-cant-implement-aes-512-key-size
+ Generate random alphanumeric string (_used for AES keys_)
https://stackoverflow.com/questions/12788799/how-to-generate-a-random-alphanumeric-string-with-erlang
+ Singular or Plural controller names?: https://stackoverflow.com/questions/35882394/phoenix-controllers-singular-or-plural
+ What's the purpose of key-rotation?
https://crypto.stackexchange.com/questions/41796/whats-the-purpose-of-key-rotation
+ Postgres Data Type for storing `bcrypt` hashed passwords: https://stackoverflow.com/questions/33944199/bcrypt-and-postgresql-what-data-type-should-be-used >> `bytea` (_byte_)
+ Do security experts recommend bcrypt? https://security.stackexchange.com/questions/4781/do-any-security-experts-recommend-bcrypt-for-password-storage/6415#6415
+ Hacker News discussion thread "***Don't use `bcrypt`***":
https://news.ycombinator.com/item?id=3724560
+ Storing Passwords in a Highly Parallelized World:
https://hynek.me/articles/storing-passwords
+ Password hashing security of argon2 versus bcrypt/PBKDF2?
https://crypto.stackexchange.com/questions/30785/password-hashing-security-of-argon2-versus-bcrypt-pbkdf2
+ The memory-hard Argon2 password hash function (ietf proposal):
https://tools.ietf.org/id/draft-irtf-cfrg-argon2-03.html
unlikely to be a "standard" any time soon...
+ Erlang Dirty Scheduler Overhead:
https://medium.com/@jlouis666/erlang-dirty-scheduler-overhead-6e1219dcc7
+ Erlang Scheduler Details and Why They Matter:
https://news.ycombinator.com/item?id=11064763
+ Why use argon2i or argon2d if argon2id exists?
https://crypto.stackexchange.com/questions/48935/why-use-argon2i-or-argon2d-if-argon2id-exists
+ Good explanation of _Custom_ Ecto Types:
https://medium.com/acutario/ecto-custom-types-a-practical-case-with-enumerize-rails-gem-b5496c2912ac
+ Consider using ETS to store encryption/decryption keys:
https://elixir-lang.org/getting-started/mix-otp/ets.html &
https://elixirschool.com/en/lessons/specifics/ets
