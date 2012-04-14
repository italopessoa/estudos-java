/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.si.poo.orkut.util.filecontrol;

import br.ufc.si.poo.orkut.beans.comunidade.Comunidade;
import br.ufc.si.poo.orkut.beans.comunidade.ComunidadePrivada;
import br.ufc.si.poo.orkut.beans.comunidade.ComunidadePublica;
import br.ufc.si.poo.orkut.beans.forum.Forum;
import br.ufc.si.poo.orkut.beans.usuario.Usuario;
import br.ufc.si.poo.orkut.beans.usuario.UsuarioComum;
import br.ufc.si.poo.orkut.beans.usuario.UsuarioVip;
import br.ufc.si.poo.orkut.interfaces.ModosSerializacao;
import br.ufc.si.poo.orkut.util.XMLNodes;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author italoney
 */
public class SaveSerialized implements ModosSerializacao {

    @Override
    public void serializaMapComunidades(Map<String, Comunidade> comunidades, String arquivo) {
        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {
            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);

            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);

            //escreve todos os dados
            out.writeObject(comunidades);
        } catch (IOException ex) {
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
            }
        }
    }

    @Override
    public void serializaMapUsuarios(Map<String, Usuario> usuarios, String arquivo) {
        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {
            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);

            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);

            //escreve todos os dados
            out.writeObject(usuarios);
        } catch (IOException ex) {
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
            }
        }
    }

    @Override
    public void serializaMapForuns(Map<String, Forum> foruns, String arquivo) {
        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {
            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);

            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);

            //escreve todos os dados
            out.writeObject(foruns);
        } catch (IOException ex) {
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
            }
        }
    }

    @Override
    public void xmlMapComunidades(Map<String, Comunidade> comunidades, String arquivo) {

        Element com = new Element(XMLNodes.COMUNIDADE_ROOT);
        // Define documento como root
        Document documento = new Document(com);
        if (comunidades.size() > 0) {
            for (Comunidade comunidade : comunidades.values()) {
                Element novaComunidade = new Element(XMLNodes.COMUNIDADE);
                // Adiciona o atributo titulo a comunidade
                novaComunidade.setAttribute(XMLNodes.TITULO_PROPERTE, String.valueOf(comunidade.getTitulo()));
                // Criando os elementos de comunidade

                Element categoria = new Element(XMLNodes.CATEGORIA_PROPERTE);
                categoria.setText(String.valueOf(comunidade.getCategoria()));
                Element type = new Element(XMLNodes.COMUNIDADE_TYPE);
                type.setText("true");

                Element usuarios = null;
                Element foruns = null;

                //<editor-fold defaultstate="ollapsed" desc="adicionar usuario">
                if (comunidade.getUsuarios().size() > 0) {
                    usuarios = new Element(XMLNodes.USUARIO_ROOT);

                    for (Usuario user : comunidade.getUsuarios()) {
                        Element usuario = new Element(XMLNodes.USUARIO);

                        usuario.setAttribute(XMLNodes.USUARIONOME_PROPERTE, user.getNome());
                        usuario.setAttribute(XMLNodes.USUARIOIDADE_PROPERTE, String.valueOf(user.getIdade()));

                        if (user instanceof UsuarioVip) {
                            usuario.setAttribute(XMLNodes.USUARIO_TYPE, "false");

                            Element recados;
                            UsuarioVip uv = (UsuarioVip) user;
                            recados = new Element(XMLNodes.RECADOS);

                            //<editor-fold defaultstate="collapsed" desc="adicionar recados">
                            if (uv.getRecados().size() > 0) {
                                for (String r : uv.getRecados()) {
                                    Element recado = new Element(XMLNodes.USUARIORECADO_PROPERTE);
                                    recado.setText(r);
                                    recados.addContent(recado);
                                }
                            }
                            if (recados != null) {
                                usuario.addContent(recados);
                            }

                            //</editor-fold>

                        } else {
                            usuario.setAttribute(XMLNodes.USUARIO_TYPE, "true");
                        }
                        usuarios.addContent(usuario);
                    }
                }

                if (comunidade instanceof ComunidadePrivada) {
                    type.setText("false");
                    ComunidadePrivada cp = (ComunidadePrivada) comunidade;

                    //<editor-fold defaultstate="collapsed" desc="adicionar foruns">
                    if (cp.getForuns().size() > 0) {
                        foruns = new Element(XMLNodes.FORUM_ROOT);
                        for (Forum f : cp.getForuns()) {
                            Element forum = new Element(XMLNodes.FORUM);
                            forum.setAttribute(XMLNodes.FORUMTITULO_PROPERTE, f.getTitulo());
                            Element mensagens = new Element(XMLNodes.FORUM_MENSAGEM_ROOT);
                            if (f.getMensagens().size() > 0) {
                                for (String m : f.getMensagens()) {
                                    Element mensagem = new Element(XMLNodes.FORUM_MENSAGEM);
                                    mensagem.setText(m);
                                    mensagens.addContent(mensagem);

                                }
                                forum.addContent(mensagens);

                            }

                            foruns.addContent(forum);
                        }
                    }
                    //</editor-fold>
                }
                //</editor-fold>               

                // Adicionando elementos nome, telefone, endereco e email no Contato
                novaComunidade.addContent(categoria);
                novaComunidade.addContent(type);
                if (usuarios != null) {
                    novaComunidade.addContent(usuarios);
                }

                if (foruns != null) {
                    novaComunidade.addContent(foruns);
                }
                // Adicionado o Contato a Agenda
                com.addContent(novaComunidade);
            }
            // AQUI VC DIZ QUAL O TIPO DE ENCODING PRA PODER ESCREVER COM ACENTO E
            // ETC
            Format forma = Format.getPrettyFormat();

            forma.setEncoding("UTF-8");
            XMLOutputter xout = new XMLOutputter(forma);



            try {
                // Criando o arquivo de saida
                FileWriter file = new FileWriter(new File(arquivo));
                // Imprimindo o XML no arquivo
                xout.output(documento, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void xmlMapUsuarios(Map<String, Usuario> usuarios, String arquivo) {

        Element us = new Element(XMLNodes.USUARIO_ROOT);
        // Define documento como root
        Document usuario = new Document(us);

        if (usuarios.size() > 0) {

            Element u;
            for (Usuario user : usuarios.values()) {
                u = new Element(XMLNodes.USUARIO);

                u.setAttribute(XMLNodes.USUARIONOME_PROPERTE, user.getNome());
                u.setAttribute(XMLNodes.USUARIOIDADE_PROPERTE, String.valueOf(user.getIdade()));

                if (user instanceof UsuarioVip) {
                    u.setAttribute(XMLNodes.USUARIO_TYPE, "false");

                    Element recados;
                    UsuarioVip uv = (UsuarioVip) user;
                    recados = new Element(XMLNodes.RECADOS);

                    //<editor-fold defaultstate="collapsed" desc="adicionar recados">
                    if (uv.getRecados().size() > 0) {
                        for (String r : uv.getRecados()) {
                            Element recado = new Element(XMLNodes.USUARIORECADO_PROPERTE);
                            recado.setText(r);
                            recados.addContent(recado);
                        }
                    }
                    if (recados != null) {
                        u.addContent(recados);
                    }

                    //</editor-fold>

                } else {
                    u.setAttribute(XMLNodes.USUARIO_TYPE, "true");
                }
                us.addContent(u);
            }
            // AQUI VC DIZ QUAL O TIPO DE ENCODING PRA PODER ESCREVER COM ACENTO E
            // ETC
            Format forma = Format.getPrettyFormat();

            forma.setEncoding("UTF-8");
            XMLOutputter xout = new XMLOutputter(forma);



            try {
                // Criando o arquivo de saida
                FileWriter file = new FileWriter(new File(arquivo));
                // Imprimindo o XML no arquivo
                xout.output(usuario, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //</editor-fold>
    }

    @Override
    public void xmlMapForuns(Map<String, Forum> foruns, String arquivo) {
        Element fr = new Element(XMLNodes.FORUM_ROOT);
        // Define documento como root
        Document forum = new Document(fr);

        //<editor-fold defaultstate="collapsed" desc="adicionar foruns">
        if (foruns.size() > 0) {
            for (Forum f : foruns.values()) {
                Element fo = new Element(XMLNodes.FORUM);
                fo.setAttribute(XMLNodes.FORUMTITULO_PROPERTE, f.getTitulo());

                if (f.getMensagens().size() > 0) {
                    Element msg = new Element(XMLNodes.FORUM_MENSAGEM_ROOT);
                    for (String m : f.getMensagens()) {
                        Element mensagem = new Element(XMLNodes.FORUM_MENSAGEM);
                        mensagem.setText(m);
                        msg.addContent(mensagem);
                    }
                    fo.addContent(msg);
                }

                fr.addContent(fo);
            }

            //</editor-fold>
            // AQUI VC DIZ QUAL O TIPO DE ENCODING PRA PODER ESCREVER COM ACENTO E
            // ETC
            Format forma = Format.getPrettyFormat();

            forma.setEncoding("UTF-8");
            XMLOutputter xout = new XMLOutputter(forma);



            try {
                // Criando o arquivo de saida
                FileWriter file = new FileWriter(new File(arquivo));
                // Imprimindo o XML no arquivo
                xout.output(forum, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Map<String, Comunidade> xmlReadComunidades(String filePath) {
        Map<String, Comunidade> comunidades = new HashMap<String, Comunidade>();

        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build(filePath);

        } catch (Exception e) {

            e.printStackTrace();
        }

        Element com = doc.getRootElement();
        //TODO estudar mai spbre isso
        @SuppressWarnings("unchecked")
        List<Element> listaComunidades = com.getChildren();

        for (Element comu : listaComunidades) {
            boolean tipoComunidade = Boolean.parseBoolean(comu.getChildText(XMLNodes.COMUNIDADE_TYPE));

            if (tipoComunidade) {
                ComunidadePublica cp = new ComunidadePublica();
                cp.setTitulo(comu.getAttributeValue(XMLNodes.TITULO_PROPERTE));
                cp.setCategoria(Integer.parseInt(comu.getChildText(XMLNodes.CATEGORIA_PROPERTE)));

                //<editor-fold defaultstate="collapsed" desc="ler usuarios">
                try {
                    List<Element> listaUsuarios = comu.getChild(XMLNodes.USUARIO_ROOT).getChildren();

                    for (Element u : listaUsuarios) {
                        boolean tipoUsuario = Boolean.parseBoolean(u.getAttributeValue(XMLNodes.USUARIO_TYPE));

                        if (tipoUsuario) {
                            UsuarioComum uc = new UsuarioComum();
                            uc.setNome(u.getAttributeValue(XMLNodes.USUARIONOME_PROPERTE));
                            uc.setIdade(Integer.parseInt(u.getAttributeValue(XMLNodes.USUARIOIDADE_PROPERTE)));

                            cp.adicionarUsuario(uc);
                        } else {
                            UsuarioVip uv = new UsuarioVip();
                            uv.setNome(u.getAttributeValue(XMLNodes.USUARIONOME_PROPERTE));
                            uv.setIdade(Integer.parseInt(u.getAttributeValue(XMLNodes.USUARIOIDADE_PROPERTE)));

                            List<Element> listaRecados = u.getChild(XMLNodes.RECADOS).getChildren();

                            for (Element recado : listaRecados) {
                                uv.adicionarRecado(recado.getText());
                            }
                            cp.adicionarUsuario(uv);
                        }
                    }

                } catch (NullPointerException e) {
                    System.err.println("Erro 1 - sem usuarios na comunidade *******************************");
                } finally {
                    comunidades.put(cp.getTitulo(), cp);
                }

                //</editor-fold>
            } else {
                ComunidadePrivada cpr = new ComunidadePrivada();
                cpr.setTitulo(comu.getAttributeValue(XMLNodes.TITULO_PROPERTE));
                cpr.setCategoria(Integer.parseInt(comu.getChildText(XMLNodes.CATEGORIA_PROPERTE)));

                //<editor-fold defaultstate="collapsed" desc="ler foruns">
                try {
                    List<Element> listaForuns = comu.getChild(XMLNodes.FORUM_ROOT).getChildren();
                    for (Element forum : listaForuns) {
                        Forum fo = new Forum();
                        fo.setTitulo(forum.getAttributeValue(XMLNodes.FORUMTITULO_PROPERTE));
                        //<editor-fold defaultstate="collapsed" desc="ler mensagens do forum">

                        List<Element> listaMensagens = forum.getChild(XMLNodes.FORUM_MENSAGEM_ROOT).getChildren();
                        for (Element mensagem : listaMensagens) {
                            fo.adicionarMensagem(mensagem.getText());
                            //</editor-fold>
                        }
                        //</editor-fold>
                        cpr.adicionarForum(fo);

                    }
                } catch (NullPointerException e) {
                    System.err.println("Erro 2  SEM FORUNS NA COMUNIDADE*******************************");
                } finally {
                    comunidades.put(cpr.getTitulo(), cpr);
                }
            }
        }

        return comunidades;
    }

    @Override
    public Map<String, Forum> xmlReadForuns(String filePath) {
        Map<String, Forum> foruns = new HashMap<String, Forum>();
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build(filePath);

        } catch (Exception e) {

            e.printStackTrace();
        }

        Element com = doc.getRootElement();
        //TODO estudar mai sobre isso
        @SuppressWarnings("unchecked")
        List<Element> listaForuns = com.getChildren();
        for (Element f : listaForuns) {
            Forum forum = new Forum();

            forum.setTitulo(f.getAttributeValue(XMLNodes.FORUMTITULO_PROPERTE));
            //<editor-fold defaultstate="collapsed" desc="ler mensagens do forum">

            try {
                List<Element> mensagens = f.getChild(XMLNodes.FORUM_MENSAGEM_ROOT).getChildren();
                for (Element mensagem : mensagens) {
                    forum.adicionarMensagem(mensagem.getText());
                }
            } catch (NullPointerException e) {
                System.err.println("Erro:  SEM MENSAGENS NO FORUM*******************************");
            } finally {
                foruns.put(forum.getTitulo(), forum);
            }
            //</editor-fold>
        }
        return foruns;
    }

    @Override
    public Map<String, Usuario> xmlReadUsuarios(String filePath) {
        Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build(filePath);

        } catch (Exception e) {

            e.printStackTrace();
        }

        Element com = doc.getRootElement();
        //TODO estudar mai spbre isso
        @SuppressWarnings("unchecked")
        List<Element> listaUsuarios = com.getChildren();
        for (Element usuario : listaUsuarios) {

            boolean tipoUsuario = Boolean.valueOf(usuario.getAttributeValue(XMLNodes.USUARIO_TYPE));
            if (tipoUsuario) {
                Usuario u = new UsuarioComum();
                u.setNome(usuario.getAttributeValue(XMLNodes.USUARIONOME_PROPERTE));
                u.setIdade(Integer.parseInt(usuario.getAttributeValue(XMLNodes.USUARIOIDADE_PROPERTE)));
            } else {
                UsuarioVip u = new UsuarioVip();

                u.setNome(usuario.getAttributeValue(XMLNodes.USUARIONOME_PROPERTE));
                u.setIdade(Integer.parseInt(usuario.getAttributeValue(XMLNodes.USUARIOIDADE_PROPERTE)));

                //<editor-fold defaultstate="collapsed" desc="ler recados do usuario">

                List<Element> listaRecados = usuario.getChild(XMLNodes.RECADOS).getChildren();
                for (Element recado : listaRecados) {
                    u.adicionarRecado(recado.getText());
                }
                //</editor-fold
                usuarios.put(u.getNome(), u);
            }
        }

        return usuarios;
    }

    @Override
    public Map<String, Forum> desserializaMapForuns(String filePath) {
         FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        Map<String, Forum> lista = null;
        try {
            //arquivo onde estao os dados serializados
            arqLeitura = new FileInputStream(filePath);

            //objeto que vai ler os dados do arquivo
            in = new ObjectInputStream(arqLeitura);

            //recupera os dados
            lista = (Map<String, Forum>) in.readObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public Map<String, Usuario> desserializaMapUsuarios(String filePath) {
       FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        Map<String, Usuario> lista = null;
        try {
            //arquivo onde estao os dados serializados
            arqLeitura = new FileInputStream(filePath);

            //objeto que vai ler os dados do arquivo
            in = new ObjectInputStream(arqLeitura);

            //recupera os dados
            lista = (Map<String, Usuario>) in.readObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public Map<String, Comunidade> desserializaMapComunidades(String filePath) {
        FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        Map<String, Comunidade> lista = null;
        try {
            //arquivo onde estao os dados serializados
            arqLeitura = new FileInputStream(filePath);

            //objeto que vai ler os dados do arquivo
            in = new ObjectInputStream(arqLeitura);

            //recupera os dados
            lista = (Map<String, Comunidade>) in.readObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return lista;
    }
}
