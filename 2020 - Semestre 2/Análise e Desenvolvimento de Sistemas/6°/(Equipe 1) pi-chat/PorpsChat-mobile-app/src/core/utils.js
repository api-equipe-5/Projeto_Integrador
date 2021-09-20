export const emailValidator = email => {
  const re = /\S+@\S+\.\S+/;

  if (!email || email.length <= 0) return 'Você deve preencher o campo de e-mail';
  if (!re.test(email)) return 'Ooops! Nós precisamos de um e-mail válido';

  return '';
};

export const passwordValidator = password => {
  if (!password || password.length <= 0) return 'Você deve preencher o campo de senha';

  return '';
};

export const nameValidator = name => {
  if (!name || name.length <= 0) return 'Você deve preencher o campo de nome';

  return '';
};