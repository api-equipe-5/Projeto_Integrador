import { usuario } from "../types/Usuarios";

const removeDeplicatedProject = (projects: any[]) => {
  const removingDuplicate = projects.reduce((unique, o: any) => {
    if (!unique.some((obj: any) => obj.projetoNome === o.projetoNome)) {
      unique.push(o);
    }
    return unique;
  }, []);

  return removingDuplicate;
};

export { removeDeplicatedProject };
