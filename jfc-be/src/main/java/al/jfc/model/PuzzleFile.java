package al.jfc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the puzzle_files database table.
 * 
 */
@Entity
@Table(name="puzzle_files")
@NamedQuery(name="PuzzleFile.findAll", query="SELECT p FROM PuzzleFile p")
public class PuzzleFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idpuzzle_files")
	private long idpuzzleFiles;

	@Lob
	private byte[] blob;

	@OneToOne
	@JoinColumn(name="puzzle_id")
	private Puzzle puzzle;
	
	private int row;

	public PuzzleFile() {
	}

	public long getIdpuzzleFiles() {
		return this.idpuzzleFiles;
	}

	public void setIdpuzzleFiles(long idpuzzleFiles) {
		this.idpuzzleFiles = idpuzzleFiles;
	}

	public byte[] getBlob() {
		return this.blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	
	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

}