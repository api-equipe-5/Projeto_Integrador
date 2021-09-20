import { Router } from 'express';

import UserController from './app/controllers/UserController';
import SessionController from './app/controllers/SessionController';

import authMiddleware from './app/middleware/auth';

const routes = new Router();

routes.post('/users', UserController.store);
routes.post('/sessions', SessionController.store);

routes.use(authMiddleware);

routes.get('/users', authMiddleware, UserController.index);
routes.get('/users/:id', authMiddleware, UserController.show);
routes.put('/users', authMiddleware, UserController.update);
routes.delete('/users/:id', authMiddleware, UserController.delete);

export default routes;
