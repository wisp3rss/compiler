	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 15
	.globl	_main                   ## -- Begin function main
	.p2align	4, 0x90
_main:                                  ## @main
## %bb.0:
	pushq	%rbx
	subq	$48, %rsp
	movl	$9, 12(%rsp)
	movl	$11, 8(%rsp)
	movabsq	$4616414798036126925, %rax ## imm = 0x4010CCCCCCCCCCCD
	movq	%rax, 16(%rsp)
	leaq	_strp(%rip), %rbx
	movq	%rbx, %rdi
	movl	$11, %esi
	xorl	%eax, %eax
	callq	_printf
	leaq	_strs(%rip), %rdi
	leaq	8(%rsp), %rsi
	xorl	%eax, %eax
	callq	___isoc99_scanf
	movl	8(%rsp), %esi
	movq	%rbx, %rdi
	xorl	%eax, %eax
	callq	_printf
	xorl	%eax, %eax
	addq	$48, %rsp
	popq	%rbx
	retq
                                        ## -- End function
	.section	__TEXT,__const
	.globl	_strp                   ## @strp
_strp:
	.asciz	"%d\n"

	.globl	_strs                   ## @strs
_strs:
	.asciz	"%d"

.subsections_via_symbols
