import { usuario } from "../types/Usuarios";

const removeDeplicated = (users: any[]) => {
  const removingDuplicate = users.reduce((unique, o: usuario) => {
    if (!unique.some((obj: usuario) => obj.id === o.id)) {
      unique.push(o);
    }
    return unique;
  }, []);

  return removingDuplicate;
};

export { removeDeplicated };
