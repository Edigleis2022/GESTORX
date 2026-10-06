package br.ifms.edu.GestorX.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import br.ifms.edu.GestorX.dto.UsuarioRequestDTO;
import br.ifms.edu.GestorX.dto.UsuarioResponseDTO;
import br.ifms.edu.GestorX.enums.TipoUsuario;
import br.ifms.edu.GestorX.exception.RegraNegocioException;
import br.ifms.edu.GestorX.model.Usuario;
import br.ifms.edu.GestorX.repository.UsuarioRepository;
import br.ifms.edu.GestorX.service.impl.UsuarioServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Testes unitários do UsuarioServiceImpl.
 *
 * Aqui usamos Mockito para simular:
 * - UsuarioRepository
 * - PasswordEncoder
 *
 * Assim não precisamos acessar banco de dados de verdade.
 */
@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    // Mock do repositório.
    // Não acessa o PostgreSQL durante o teste.
    @Mock
    private UsuarioRepository repository;

    // Mock do encoder.
    // Simula a criptografia da senha.
    @Mock
    private PasswordEncoder passwordEncoder;

    // Classe que estamos realmente testando.
    @InjectMocks
    private UsuarioServiceImpl service;

    private UsuarioRequestDTO dto;

    /**
     * Executado antes de cada teste.
     * Cria um usuário válido para reutilizarmos nos testes.
     */
    @BeforeEach
    void setUp() {

        dto = new UsuarioRequestDTO();

        dto.setNome("João da Silva");
        dto.setEmail("joao@teste.com");
        dto.setSenha("Teste@123");
        dto.setTipoUsuario(TipoUsuario.ADMIN);
        dto.setCpf("12345678900");
        dto.setCargo("Gerente");
        dto.setEstabelecimento("Mercado Teste");
    }

    /**
     * TU01
     *
     * Testa o cadastro de um usuário quando
     * CPF e e-mail ainda não estão cadastrados.
     */
    @Test
    void deveSalvarUsuarioComDadosValidos() {

        // Simula que CPF ainda não existe.
        when(repository.existsByCpf(dto.getCpf()))
                .thenReturn(false);

        // Simula que e-mail ainda não existe.
        when(repository.existsByEmail(dto.getEmail()))
                .thenReturn(false);

        // Simula a criptografia da senha.
        when(passwordEncoder.encode(dto.getSenha()))
                .thenReturn("senhaCriptografada");

        // Simula o usuário salvo pelo banco.
        Usuario usuarioSalvo = new Usuario();

        usuarioSalvo.setId(1L);
        usuarioSalvo.setNome(dto.getNome());
        usuarioSalvo.setEmail(dto.getEmail());
        usuarioSalvo.setSenha("senhaCriptografada");
        usuarioSalvo.setTipoUsuario(dto.getTipoUsuario());
        usuarioSalvo.setCpf(dto.getCpf());
        usuarioSalvo.setCargo(dto.getCargo());
        usuarioSalvo.setEstabelecimento(dto.getEstabelecimento());

        when(repository.save(any(Usuario.class)))
                .thenReturn(usuarioSalvo);

        // Executa o método que estamos testando.
        UsuarioResponseDTO resultado = service.salvar(dto);

        // Verifica se o resultado não é nulo.
        assertNotNull(resultado);

        // Verifica se o usuário recebeu ID.
        assertEquals(1L, resultado.getId());

        // Verifica o nome.
        assertEquals("João da Silva", resultado.getNome());

        // Verifica o e-mail.
        assertEquals("joao@teste.com", resultado.getEmail());

        // Confirma que o repositório foi chamado para salvar.
        verify(repository).save(any(Usuario.class));
    }

    /**
     * TU02
     *
     * Testa a regra que impede cadastrar
     * dois usuários com o mesmo CPF.
     */
    @Test
    void deveRecusarUsuarioComCpfDuplicado() {

        // Simula CPF já existente no banco.
        when(repository.existsByCpf(dto.getCpf()))
                .thenReturn(true);

        // Executa e verifica se a exceção esperada acontece.
        RegraNegocioException exception = assertThrows(
                RegraNegocioException.class,
                () -> service.salvar(dto)
        );

        // Confirma a mensagem da regra de negócio.
        assertEquals("CPF já cadastrado", exception.getMessage());

        // Como o CPF já existe, não deve tentar salvar.
        verify(repository, never()).save(any(Usuario.class));
    }

    /**
     * TU03
     *
     * Testa a regra que impede cadastrar
     * dois usuários com o mesmo e-mail.
     */
    @Test
    void deveRecusarUsuarioComEmailDuplicado() {

        // CPF é válido/não duplicado.
        when(repository.existsByCpf(dto.getCpf()))
                .thenReturn(false);

        // E-mail já existe.
        when(repository.existsByEmail(dto.getEmail()))
                .thenReturn(true);

        // Esperamos uma exceção de regra de negócio.
        RegraNegocioException exception = assertThrows(
                RegraNegocioException.class,
                () -> service.salvar(dto)
        );

        // Confirma a mensagem.
        assertEquals("Email já cadastrado", exception.getMessage());

        // Não deve salvar usuário duplicado.
        verify(repository, never()).save(any(Usuario.class));
    }
}