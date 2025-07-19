DELETE FROM public.library
	WHERE type = '<type>';

UPDATE public.library
	SET records = '[]';