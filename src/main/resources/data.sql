INSERT INTO Graph (id, name) values (1, 'Roadmap Java')
INSERT INTO Graph (id, name) values (2, 'Roadmap Golang')
INSERT INTO Graph (id, name) values (3, 'Go Developer in 2021')


INSERT INTO Node (id, node_id, type, label, posX, posY, graph_id) values (1, '1', 'input', 'First node', 220, 60, 2)

-- INSERT INTO Node (id, node_id, label, posX, posY, graph_id) values (2, '2', 'Second node', 220, 200, 2)

INSERT INTO Node (id, node_id, label, posX, posY, graph_id) values (3, '3', 'Java', 220, 260, 2)
INSERT INTO Node (id, node_id, label, posX, posY, graph_id) values (4, '4', 'Gradle/Maven, Library', 220, 320, 2)
INSERT INTO Node (id, node_id, label, posX, posY, graph_id) values (5, '5', 'SQL fundamentals', 220, 380, 2)




INSERT INTO Edge (id, edge_id, source, target, type, animated, graph_id) values (3, 'e1-2', '1', '2', 'special', true, 2)
INSERT INTO Edge (id, edge_id, source, target, type, graph_id) values (4, 'e2-3', '2', '3', 'special', 2)


INSERT INTO Node (id, node_id, label, posX, posY, graph_id) values (6, '2', 'Go Developer in 2021', 250, 150, 1)