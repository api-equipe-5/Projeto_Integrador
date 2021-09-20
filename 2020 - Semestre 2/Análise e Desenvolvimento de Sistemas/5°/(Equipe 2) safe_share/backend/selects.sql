select p.descricao, count(cp.produtos_id) as qtd
from produto p
inner join carrinho_produtos cp
on p.id = cp.produtos_id
group by p.descricao;


select c.cliente_id, p.descricao, count(cp.produtos_id) as qtd
from carrinho c
inner join carrinho_produtos cp
on cp.carrinho_id = c.id
inner join produto p
on p.id = cp.produtos_id
group by (p.descricao, c.cliente_id);