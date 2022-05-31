import React from 'react';
import { ActionIcon, Group, Menu, Title } from '@mantine/core';
import { Hash } from 'tabler-icons-react';
import { Link } from 'react-router-dom';
import { TitleLink } from 'types';

interface ManageTitleProps {
  titleLinks: TitleLink[];
  title: string;
}

export default function ManageTitle({ titleLinks, title }: ManageTitleProps) {

  const titleLinksFragment = titleLinks.map(titleLink => (
    <Menu.Item key={titleLink.label} component={Link} to={titleLink.link}>
      {titleLink.label}
    </Menu.Item>
  ));

  return (
    <Group spacing="xs">
      <Menu
        control={(
          <ActionIcon color="blue" variant="filled">
            <Hash/>
          </ActionIcon>
        )}
      >
        {titleLinksFragment}
      </Menu>
      <Title order={3}>{title}</Title>
    </Group>
  );
}
