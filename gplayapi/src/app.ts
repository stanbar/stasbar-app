import express from 'express';
import cookieParser from 'cookie-parser';
import logger from 'morgan';
import router from './lib';

const app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(cookieParser());

app.use('/api', router);

export default app;
