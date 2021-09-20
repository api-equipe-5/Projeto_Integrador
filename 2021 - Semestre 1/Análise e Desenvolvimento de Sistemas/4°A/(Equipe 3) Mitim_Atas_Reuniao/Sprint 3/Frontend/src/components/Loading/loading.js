import { Spin } from 'antd';
import { LoadingOutlined } from '@ant-design/icons';


export const LoadingScreen = () => {
    const antIcon = <LoadingOutlined style={{ fontSize: 50 }} spin />;
    return (
        <>
            <div style={{ marginTop: 'auto', marginBottom: 'auto' }}>
                <Spin style={{ fontSize: 25 }} tip='Aguarde um momento..' indicator={antIcon} >
                </Spin>
            </div>
        </>
    );
};




