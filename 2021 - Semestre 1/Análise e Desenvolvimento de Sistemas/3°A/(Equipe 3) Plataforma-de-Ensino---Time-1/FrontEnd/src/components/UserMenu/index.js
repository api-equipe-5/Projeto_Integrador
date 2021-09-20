import React from 'react';
import { Menu, Dropdown, Avatar } from 'antd';
import { FiUser, FiChevronDown, FiSettings, FiLogOut } from 'react-icons/fi';
import { useAuth } from '~/hooks/AuthContext';

export default function UserMenu() {
  const { signOut, user } = useAuth();

  const menu = (
    <Menu>
      <Menu.Item icon={<FiUser style={{ marginRight: '5px' }} />}>
        Meu Perfil
      </Menu.Item>
      <Menu.Item icon={<FiSettings style={{ marginRight: '5px' }} />}>
        Configurações
      </Menu.Item>
      <Menu.Divider />
      <Menu.Item
        onClick={signOut}
        icon={<FiLogOut style={{ marginRight: '5px' }} />}
        danger
      >
        Sair
      </Menu.Item>
    </Menu>
  );

  return (
    <Dropdown overlay={menu}>
      <div>
        {user.name} <Avatar style={{ marginLeft: '20px' }} icon={<FiUser />} />{' '}
        <FiChevronDown />
      </div>
    </Dropdown>
  );
}
