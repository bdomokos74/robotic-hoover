drop table if exists public.simulations;
CREATE TABLE public.simulations
(
    id IDENTITY,
    input VARCHAR2(1000) NOT NULL,
    output VARCHAR2(1000) NOT NULL
);
