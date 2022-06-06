insert into persona
    (
     documento,
     nombres,
     apellidos,
     fecha_nacimiento,
     fecha_creacion,
     estado,
     perfil
     ) values
    (
     '9098989',
     'Jessica',
     'Ramirez',
     CURRENT_TIMESTAMP(),
     CURRENT_TIMESTAMP(),
     'CREADO',
     'USUARIO'
     );

insert into libro_stock(
    unidades_prestamo,
    valor_prestamo,
    unidades_venta,
    valor_venta
)values (
            5,
            6.4,
            200,
            30.0
        );
insert into libro(
                  nombre,
                  autor,
                  fecha_lanzamiento,
                  paginas,
                  fecha_creacion,
                  estado,
                  LIBRO_STOCK_ID
)values (
         'Buscando las estrellas',
         'Rafa Mahka',
         CURRENT_TIMESTAMP(),
         245,
         CURRENT_TIMESTAMP(),
         'CREADO',
         1
        );

insert into factura(
    fecha_creacion,
    total_pago,
    estado_pago,
    cliente_id,
    administrador_id
)values (
    CURRENT_TIMESTAMP(),
    12.2,
    'PENDIENTE_PAGO',
    1,
    1
);

insert into producto_factura(
    fecha_creacion,
    tipo_servicio,
    libro_id,
    factura_id
)values (
    CURRENT_TIMESTAMP(),
    'VENTA',
    1,
    1
);


