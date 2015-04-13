package br.com.springbank.service;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbank.dao.GerenteDao;
import br.com.springbank.model.Gerente;
import br.com.springbank.util.Auxiliar;

@Service
@Transactional
public class GerenteServiceImpl implements GerenteService {

	@Autowired
	private GerenteDao gerenteDao;

	@Override
	public void salvar(Gerente gerente) throws ServiceException, ParseException {

		// verifica se existe gerente com o mesmo cpf
		validarCpfGerente(gerente);

		// verifica se existe gerente com o mesmo email
		validarEmail(gerente);

		// formartarData
		Date date = formatarDataSql(gerente.getDataContratacao());

		gerente.setDataContratacao(date);

		// regras de negocio
		gerenteDao.salvar(gerente);
	}

	@Override
	public Collection<Gerente> listar() {
		return gerenteDao.listar();
	}

	@Override
	public Gerente buscarId(Long id) {

		Gerente gerente = gerenteDao.buscarId(id);

		return gerente;
	}

	@Override
	public void deletar(Long id) {
		gerenteDao.deletar(id);
	}

	/****************
	 * VALIDACAO
	 * 
	 * @throws Exception
	 **************/

	private void validarCpfGerente(Gerente gerente) throws ServiceException {

		List<Gerente> gerentes = gerenteDao.buscarCpfIdDiferente(gerente);

		if (gerentes.size() > 0) {
			throw new ServiceException("Já existe um gerente com o mesmo CPF");
		}

	}

	private void validarEmail(Gerente gerente) throws ServiceException {

		List<Gerente> gerentes = gerenteDao.buscarEmailIdDiferente(gerente);

		if (gerentes.size() > 0) {
			throw new ServiceException("Já existe um gerente com o mesmo email");
		}

	}

	private Date formatarDataSql(Date date) {

		try {
			// formatarData
			String dataFormatada = Auxiliar.dateToStringFormatada(date);

			Date dataFormatadaSql;

			dataFormatadaSql = Auxiliar.stringToDateFormatada(dataFormatada);

			return dataFormatadaSql;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
